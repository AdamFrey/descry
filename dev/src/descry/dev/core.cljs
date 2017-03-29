(ns descry.dev.core
  (:require [descry.core :as descry]
            [descry.ui.core :as descry-ui]
            [datascript.core :as d]))

(enable-console-print!)

(def schema
  {:state/part {:db/unique :db.unique/identity}

   :user/name      {:db/cardinality :db.cardinality/one
                    :db/unique      :db.unique/identity}
   :user/verified? {:db/cardinality :db.cardinality/one}})

(defonce conn (d/create-conn schema))

(def empty-db (d/db conn))

(defn set-up-descry [conn]
  (descry/enable-descry! conn
    {:exclude-attributes #{:user/extra-attr}}))

(defn init! []
  (d/transact conn
    [{:user/name      "Adam Frey"
      :user/verified? true
      :user/extra-attr "Something I don't want to see"}
     {:user/name      "Sideshow Bob"
      :user/verified? false}])

  (set-up-descry conn))

(defn reload! []
  (set-up-descry conn)
  (descry-ui/mount-descry))
