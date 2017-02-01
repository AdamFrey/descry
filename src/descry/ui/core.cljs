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
  (let [entities (into {}
                   (map (fn [[key val]]
                          [key (attrs->entity-map val)]) entities))
        headers  (reduce
                   (fn [acc [_ e-map]]
                     (apply conj acc (keys e-map)))
                   #{}
                   entities)
        sorted-headers (sort headers)]
    [:table
     [:tr
      [:th "id"]
      (for [header sorted-headers]
        [:th (str header)])]
     (for [[id entity] entities]
       [:tr
        [:td id]
        (for [header sorted-headers]
          [:td (str (get entity header))])])]))

(defn mount [element source]
  (rum/mount (entity-table (ds/all-entities source)) element))
