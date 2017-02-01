(ns descry.core
  (:require [descry.protocols.datascript :as ds]
            [descry.ui.core :as ui]))

(defn all-entities [source]
  (ds/all-entities source))

(def mount ui/mount)
