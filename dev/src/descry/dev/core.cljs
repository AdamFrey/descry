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

(defn init! []
  (d/transact conn
    [{:user/name      "Adam Frey"
      :user/verified? true}
     {:user/name      "Sideshow Bob"
      :user/verified? false}])
  (descry/enable-descry! conn))

(defn reload! [])
