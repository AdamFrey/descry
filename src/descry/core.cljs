(ns descry.core
  (:require [descry.protocols.datascript :as ds]
            [descry.ui.core :as ui]
            [descry.ui.launcher :as launcher]
            [descry.data :as data]))

(defn all-entities [source]
  (ds/all-entities source))

(defn- initialize-descry-data [source opts]
  (reset! data/initialized? true)
  (reset! data/source source)
  (reset! data/options opts))

(defn mount-descry [el source opts]
  (when-not @data/initialized?
    (initialize-descry-data source opts)
    #_(ui/mount)))

(defn enable-descry!
  ([source] (enable-descry! source {}))
  ([source opts]
   (when-not @data/initialized?
     (initialize-descry-data source opts)
     (js/setTimeout launcher/render-descry-launch 100 opts))))
