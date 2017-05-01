(ns descry.ui.core
  (:require [descry.data :as data]
            [descry.protocols.datascript :as ds]
            [goog.object :as obj]
            [clojure.pprint :as pp]
            [clojure.string :as string]
            [clojure.set :as set]
            [rum.core :as rum]))
(def css
  "body{background:#273539;color:#86acbf;}
   .cell{padding:10px;border-width:0px; border-style: solid; border-color: rgba(255, 255, 255, 0.09)}
   .header{color: #4CAF50; font-size: .85rem}
   .group.header{color:#34a2f9;font-size: .8rem; font-family: Input Mono, Lucida Sans Unicode, Lucida Grande, Sans-Serif;white-space:nowrap}
   .entity{margin-bottom: 4rem}
   table{border-collapse: collapse; font-size: .9rem;font-family: Input Mono, Lucida Sans Unicode, Lucida Grande, Sans-Serif;width: 100%;text-align:left}
   thead{border-bottom: 0px solid rgba(255, 255, 255, 0.09)}
   th.header{padding: 10px 10px}
   .bb{border-bottom-width: 0px }
   .bl{border-left-width: 1px }
   .br{border-right-width: 1px }
   .pa10{padding: 10px}
   tr.cell>td:first-child{border-left-color:#34a2f9;}
   tr.cell:nth-child(odd){background:rgba(255, 255, 255, 0.04)}
   tr.cell:last-child{border-bottom-width: 1px}
   thead>tr>th:first-child{text-align:center;}
   thead>tr{border-top:1px solid #34a2f9;border-left:1px solid #34a2f9;background:rgba(16, 32, 37, 0.46)}
")

(def cell-border "1px solid rgba(255, 255, 255, 0.09)")
(def thead-border-bottom cell-border)
(def column-header-color "#bf861d")
(def required-coll
  [
   [:activity/display-name
    :activity/name
    :activity/photo]

   [:amenity/display-name
    :amenity/name]

   [:page/name
    :page/title
    :page/call-to-action]

   [:listing/name
    :listing/general-property-name
    :listing/local-area-name
    :listing/summary
    :listing/description]])

(defn headers-contain-required [headers required]
  (when (every? #((set headers) %) required) required))

(defn order-headers
  [headers required-coll]
   (if-let [these-come-first-seq (some #(headers-contain-required headers %) required-coll)]
     (let [diff (set/difference (set headers) (set these-come-first-seq))]
       (concat these-come-first-seq (into '() diff)))
     headers))


(defn entities->headers
  ([entities] (entities->headers {}))
  ([entities options]
   (let [entities (->> entities
                     (reduce
                       (fn [acc [_ e-map]]
                         (apply conj acc (keys e-map))) #{})
                     (filter (fn [header]
                               (not (contains? (:exclude-attributes options) header))))
                     (sort))]
                     #_(pp/pprint entities)

    (if required-coll
      (order-headers entities required-coll)
      entities)
     )))




#_(prn (order-headers headers [page-headers listing-headers]))

(defn most-frequent
  "Returns the element that most frequently occurs in a collection.
  non-deterministic in the case of a tie"
  [items]
  (->> items
    (frequencies)
    (sort-by val)
    (reverse)
    (ffirst)))

(defn group-entities-by-common-namespace
  "Returns a collection of entities grouped by their most common attribute
  namespace."
  [entities]
  (group-by
    (fn [[_ e-map]]
      (most-frequent (map namespace (keys e-map))))
    entities))


(defn entities->tables [entities options]
  #_(if-let [schema (:schema options)]
    []
    [{:headers (entities->headers entities options)
      :entities entities}])
  (->> entities
    (group-entities-by-common-map)
    (namespace (fn [[table-name entities :as thing]]
           {:table-name table-name
            :headers (entities->headers entities options)
            :entities entities}))))


(defn cell-string [entity header]
  (let [val (get entity header)
        string? (string? val)
        img-url? (when string? (= "//" (str (first val) (second val))))
        img-tag (when img-url? [:a {:target "_blank" :href val}
                                [:img {:src (str val "?h=34")}]])

        too-long-text? (when string? (> (count val) 100))
        display-val (when string? (str (subs val 0 100) (when too-long-text? " ...")))]
    (cond
      img-url? img-tag
      display-val display-val
      :else (str val))))


(rum/defc entity-table
  < rum/static
  [entities]
  [:div
   (for [{:keys [table-name headers entities]} (entities->tables entities @data/options)]
     [:div.entity
      [:h2.group.header
      (when table-name [:span
                        (string/upper-case table-name) "  "
                        #_(map #(vector :span {:style {:opacity (- 1 (/ % 100))}} "-") (range 1 100))])]
      [:table {:key table-name}
       [:thead
        [:tr {}
         [:th.header {} "id"]
         (for [header headers]
           [:th.header.cell.bl.pa10 {:key (str header)}
            (str header)])]]
       [:tbody {}
          (for [[id entity] entities]
            [:tr.bb.cell {:key id}
             [:td.pa10.bl.br.cell  id]
             (for [header headers]
               [:td.pa10.br.cell
                (cell-string entity header)])])]]])])

(defn mount-descry
  "Mounts descry into a document. If no document is provided, fallsback to the
  window stored in data/window."
  ([] (mount-descry (.-document @data/window)))
  ([document]
   (let [base-element (.getElementById document "descry")]
     (rum/mount (entity-table (ds/all-entities (ds/db @data/source)))
       base-element))))

(def descry-html
  (str
  "<!DOCTYPE html>
   <html>\n
   <head>
     <title>Descry</title>
     <style type=\"text/css\">"
     css
    "</style>
   </head>
   <body>
     <div id=\"descry\"></div>
   </body>
   </html>"))

(defn open-window []
  (let [w (js/window.open "" "Descry" "width=800,height=400,resizable=yes,scrollbars=yes,status=no,directories=no,toolbar=no,menubar=no")
        d (.-document w)]
    (reset! data/window w)
    (.open d)
    (.write d descry-html)
    (obj/set w "onload" #(mount-descry d))
    (.close d)))
