(ns descry.protocols.datascript
  (:require [datascript.core :as d]))

(def db d/db)

(defn attrs->entity-map [attrs]
  (into {}
    (map (juxt #(nth % 1) #(nth % 2)))
    attrs))

(defn all-entities
  "Returns a map of all entities in the db keyed by their entity id to an
  attribute map of each entity's attributes."
  [db]
  (->> db
    (d/q '[:find ?e ?a ?v
           :where [?e ?a ?v]])
    (group-by first)
    (into {}
      (map (fn [[key val]]
             [key (attrs->entity-map val)])))))
