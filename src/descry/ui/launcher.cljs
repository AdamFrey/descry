(ns descry.ui.launcher
  (:require [descry.data :as data]
            [descry.ui.core :as ui]
            [goog.object :as obj]
            [rum.core :as rum]))

(def descry-html
  "<!DOCTYPE html>
   <html>\n
   <head>
     <title>Descry</title>
   </head>
   <body>
     <div id=\"descry\"></div>
   </body>
   </html>")

(defn open-window []
  (let [w (js/window.open "" "Descry" "width=800,height=400,resizable=yes,scrollbars=yes,status=no,directories=no,toolbar=no,menubar=no")
        d (.-document w)]
    (.open d)
    (.write d descry-html)
    (obj/set w "onload" #(ui/mount-descry w d))
    (.close d)))

(rum/defc descry-launch-button
  < rum/static
  []
  [:div {:style {:position "fixed"
                 :left     "10px"
                 :top      "0px"
                 :z-index  "999"}}
   [:div
    {:style {:fontFamily "Consolas,Monaco,Courier New,monospace"
             :fontSize "12px"
             :display "inline-block"
             :background-color "#CCCCCC"
             :cursor "pointer"
             :padding "6px"
             :text-align "left"
             :border-radius "2px"
             :border-bottom-left-radius "0px"
             :border-bottom-right-radius "0px"
             :padding-left "2rem"}
     :on-click open-window}
    "descry"]])

(defn render-descry-launch []
  (let [div (js/document.createElement "div")]
    (js/document.body.appendChild div)
    (rum/mount (descry-launch-button) div)))
