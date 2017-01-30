(ns descry.dev.core
  (:require [descry.core :as descry]))

(enable-console-print!)

(defn init! []
  (descry/hello))

(defn reload! []
  (prn "-----!!"))
