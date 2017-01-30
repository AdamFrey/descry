(ns descry.core
  (:require [descry.protocols.datascript :as ds]))

(defn all-entities [source]
  (ds/all-entities source))
