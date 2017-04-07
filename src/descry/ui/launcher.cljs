(ns descry.ui.launcher
  (:require [descry.data :as data]
            [descry.ui.core :as ui]
            [goog.object :as obj]
            [rum.core :as rum]))

(rum/defc descry-launch-button
  < rum/static
  []
  [:#descry-launcher
   {:style {:position "fixed"
            :right    "0px"
            :bottom   "0px"
            :z-index  "999"}}
   [:div
    {:style {:fontFamily                 "Consolas,Monaco,Courier New,monospace"
             :fontSize                   "12px"
             :display                    "inline-block"
             :background-color           "#CCCCCC"
             :cursor                     "pointer"
             :padding                    "6px"
             :text-align                 "left"
             :border-radius              "2px"
             :border-bottom-left-radius  "0px"
             :border-bottom-right-radius "0px"
             :padding-left               "2rem"}
     :on-click ui/open-window}
    "descry"]])

(defn render-descry-launch []
  (let [div (js/document.createElement "div")]
    (js/document.body.appendChild div)
    (rum/mount (descry-launch-button) div)))
