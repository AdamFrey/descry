(ns descry.dev.core
  (:require [descry.core :as descry]
            [descry.ui.core :as descry-ui]
            [descry.dev.rschema :as rschema]
            [descry.dev.dbmock :as dbmock]
            [datascript.core :as d]))

(enable-console-print!)

(def schema
  {:state/part {:db/unique :db.unique/identity}

   :user/name      {:db/cardinality :db.cardinality/one
                    :db/unique      :db.unique/identity}
   :user/verified? {:db/cardinality :db.cardinality/one}})

(defonce conn (d/create-conn rschema/schema))

(def empty-db (d/db conn))

#_(defn set-up-descry [conn]
  (descry/enable-descry! conn
    {:exclude-attributes #{:user/extra-attr}
     :schema             {"User"      #{:user/name :user/verified?}
                          "Todo List" #{:todo-list/name}}}))

(defn set-up-descry [conn]
  (descry/enable-descry! conn
    {:exclude-attributes #{:page/content :waiver/text}}))

(defn init! []
  (d/transact conn
    (concat dbmock/mock-data dbmock/offline-data)
    #_[{:user/name       "Adam Frey"
      :user/verified?  true
      :user/extra-attr "Something I don't want to see"}
     {:user/name      "Sideshow Bob"
      :user/verified? false
      :other/thing     "ok"}
     {:todo-list/name "Todo List."}])

  (set-up-descry conn))

(defn reload! []
  (set-up-descry conn)
  (descry-ui/mount-descry))
