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
        headers        (reduce
                         (fn [acc [_ e-map]]
                           (apply conj acc (keys e-map)))
                         #{}
                         entities)
        sorted-headers (sort headers)]
    [:table {:style {:border-collapse "collapse"
                     :font-family     "Lucida Sans Unicode, Lucida Grande, Sans-Serif"
                     :width           "100%"
                     :text-align      "left"}}
     [:thead {:style {:border-bottom "2px solid #000"}}
      [:tr
       [:th "id"]
       (for [header sorted-headers]
         [:th {:key header} (str header)])]]
     [:tbody
      (for [[id entity] entities]
        [:tr {:key   id
              :style {:border-bottom  "1px solid black"}}
         [:td {:style {:padding "10px"}} id]
         (for [header sorted-headers]
           [:td {:key header} (str (get entity header))])])]]))

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

(defn mount-descry [w d]
  (let [base-element (.getElementById d "descry")]
    (rum/mount (entity-table (ds/all-entities (ds/db @data/source)))
      base-element)))

(defn open-window []
  (let [w (js/window.open "" "Descry" "width=800,height=400,resizable=yes,scrollbars=yes,status=no,directories=no,toolbar=no,menubar=no")
        d (.-document w)]
    (.open d)
    (.write d descry-html)
    (obj/set w "onload" #(mount-descry w d))
    (.close d)))

(rum/defc descry-launch-button
  < rum/static
  []
  [:div {:style {:position "fixed"
                 :left     "10px"
                 :top      "0px"
                 :z-index  "999"}}
   [:div
    {:style {:fontFamily "Consolas,Monaco,Courier New,monospace"
             :fontSize "12px"
             :display "inline-block"
             :background-color "#CCCCCC"
             :cursor "pointer"
             :padding "6px"
             :text-align "left"
             :border-radius "2px"
             :border-bottom-left-radius "0px"
             :border-bottom-right-radius "0px"
             :padding-left "2rem"}
     :on-click open-window}
    "descry"]])

(defn render-descry-launch []
  (let [div (js/document.createElement "div")]
    (js/document.body.appendChild div)
    (rum/mount (descry-launch-button) div)))
