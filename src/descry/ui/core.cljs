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

(defn mount-descry [w d]
  (let [base-element (.getElementById d "descry")]
    (rum/mount (entity-table (ds/all-entities (ds/db @data/source)))
      base-element)))
