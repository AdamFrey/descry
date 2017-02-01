(ns descry.ui.core
  (:require [rum.core :as rum]
            [descry.protocols.datascript :as ds]))

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

(defn mount [element source]
  (rum/mount (entity-table (ds/all-entities source)) element))
