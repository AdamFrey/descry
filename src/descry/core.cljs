(ns descry.core
  (:require [descry.protocols.datascript :as ds]
            [descry.ui.core :as ui]
            [descry.data :as data]))

(defn all-entities [source]
  (ds/all-entities source))

(defn enable-descry! [source]
  (when-not @data/initialized?
    (reset! data/initialized? true)
    (reset! data/source source)
    (js/setTimeout ui/render-descry-launch 100)))
