(ns descry.protocols.datascript
  (:require [datascript.core :as d]))

(def db d/db)

(defn all-entities [db]
  (->> db
    (d/q '[:find ?e ?a ?v
           :where [?e ?a ?v]])
    (group-by first)))
