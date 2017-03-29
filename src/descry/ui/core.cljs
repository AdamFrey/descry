(ns descry.ui.core
  (:require [descry.data :as data]
            [descry.protocols.datascript :as ds]
            [goog.object :as obj]
            [rum.core :as rum]))

(defn attrs->entity-map [attrs]
  (into {}
    (map (juxt #(nth % 1) #(nth % 2)))
    attrs))

(rum/defc entity-table
  < rum/static
  [entities]
  (let [entities       (into {}
                         (map (fn [[key val]]
                                [key (attrs->entity-map val)]) entities))
        headers        (->> entities
                         (reduce
                           (fn [acc [_ e-map]]
                             (apply conj acc (keys e-map))) #{})
                         (filter (fn [header] (not (contains? (:exclude-attributes @data/options) header))))
                         (sort))]
    [:table {:style {:border-collapse "collapse"
                     :font-family     "Lucida Sans Unicode, Lucida Grande, Sans-Serif"
                     :width           "100%"
                     :text-align      "left"}}
     [:thead {:style {:border-bottom "2px solid #000"}}
      [:tr
       [:th "id"]
       (for [header headers]
         [:th {:key header} (str header)])]]
     [:tbody
      (let [cell-styles {:padding "10px"
                         :border-right "1px solid black"}]
        (for [[id entity] entities]
          [:tr {:key   id
                :style {:border-bottom  "1px solid black"}}
           [:td {:style (assoc cell-styles
                          :border-left "1px solid black")} id]
           (for [header headers]
             [:td {:key header
                   :style cell-styles}
              (str (get entity header))])]))]]))

(defn mount-descry
  "Mounts descry into a document. If no document is provided, fallsback to the
  window stored in data/window."
  ([] (mount-descry (.-document @data/window)))
  ([document]
   (let [base-element (.getElementById document "descry")]
     (rum/mount (entity-table (ds/all-entities (ds/db @data/source)))
       base-element))))

(def descry-html
  "<!DOCTYPE html>
   <html>\n
   <head>
     <title>Descry</title>
   </head>
   <body>
     <div id=\"descry\"></div>
   </body>
   </html>")

(defn open-window []
  (let [w (js/window.open "" "Descry" "width=800,height=400,resizable=yes,scrollbars=yes,status=no,directories=no,toolbar=no,menubar=no")
        d (.-document w)]
    (reset! data/window w)
    (.open d)
    (.write d descry-html)
    (obj/set w "onload" #(mount-descry d))
    (.close d)))

