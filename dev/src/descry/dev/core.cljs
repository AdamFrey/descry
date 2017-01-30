(ns descry.dev.core
  (:require [descry.core :as descry]
            [datascript.core :as d]))

(enable-console-print!)

(def schema
  {:state/part {:db/unique :db.unique/identity}

   :user/name      {:db/cardinality :db.cardinality/one
                    :db/unique      :db.unique/identity}
   :user/verified? {:db/cardinality :db.cardinality/one}})

(defonce conn (d/create-conn schema))

(def empty-db (d/db conn))

(defn init! [])

(defn reload! []
  (-> empty-db
    (d/with [{:user/name      "Adam Frey"
              :user/verified? true}
             {:user/name      "Sideshow Bob"
              :user/verified? false}])
    (:db-after)
    (descry/all-entities)
    (prn)))
