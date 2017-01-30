(def project 'descry)
(def version "0.1.0-master-0001")

(set-env!
  :source-paths   #{"src"}
  :dependencies   '[[org.clojure/clojure "1.9.0-alpha14" :scope "test"]
                    [org.clojure/clojurescript "1.9.456" :scope "provided"]
                    [datascript "0.15.5" :scope "provided"]
                    [rum "0.10.8"]

                    ;; Test Dependencies
                    [pandeiro/boot-http "0.7.6" :scope "test"]
                    [adzerk/boot-cljs "2.0.0-SNAPSHOT" :scope "test"]
                    [powerlaces/boot-figreload "0.1.0-SNAPSHOT" :scope "test"]
                    [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
                    [com.cemerick/piggieback "0.2.1"  :scope "test"]
                    [weasel "0.7.0"  :scope "test"]
                    [org.clojure/tools.nrepl "0.2.12" :scope "test"]])


(task-options!
  pom {:project     project
       :version     version
       :description "Visualization of Datascript state"
       :url         "http://example/FIXME"
       :scm         {:url "https://github.com/adamfrey/descry"}
       :license     {"MIT" "https://opensource.org/licenses/MIT"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

;; Dev ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(require
  '[adzerk.boot-cljs      :refer [cljs]]
  '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
  '[powerlaces.boot-figreload    :refer [reload]]
  '[pandeiro.boot-http    :refer [serve]])

(defn set-development-env! []
  (set-env!
    ;; :dependencies
    :source-paths #(conj % "dev/src")
    :resource-paths #{"dev/resources"}))

(deftask dev []
  (set-development-env!)
  (comp (serve :port 4000)
    (watch)
    (speak)
    (reload)
    (cljs-repl :nrepl-opts {:port 5055})
    (cljs)))
