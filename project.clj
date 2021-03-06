(defproject webapp "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://exampl.com/FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 ;; cljs dependency
                 [org.clojure/clojurescript "1.7.228"]

                 ;; Backend dependencies
                 [compojure "1.4.0"]
                 [http-kit "2.1.19"]

                 [hiccup "1.0.5"]
                 ;;[ring/ring-core "1.3.2" :exclusions [javax.servlet/servlet-api]]
                 ;;[ring/ring-servlet "1.3.2" :exclusions [javax.servlet/servlet-api]]
                 ;;[ring/ring-defaults "0.1.2" :exclusions [javax.servlet/servlet-api]]
                 ;;[ring/ring-json "0.3.1"]

                 ;;[cc.qbits/jet "0.5.4"]
                 [garden "1.2.5"]
                 [cljs-ajax "0.3.11"]
                 [enfocus "2.1.1"]

                 [org.clojure/data.json "0.2.6"]
                 ;;mongo json
                 [cheshire "5.3.1"]

                 [com.novemberain/monger "2.1.0"]]


  ;; beign cljs
  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-ring "0.9.3"]
            [lein-garden "0.2.6"]]
  :cljsbuild {:builds
            [{:id "app"
              :source-paths ["src/cljs"]
              :compiler {:output-to "resources/public/js/app.js"
                         :output-dir "resources/public/js/out"
                         :source-map true
                         :optimizations :none
                         :asset-path "/static/js/out"
                         :main "webapp.core"
                         :pretty-print true}}]}
  ;; end cljs
  :source-paths ["src/clj"]
  :hooks [leiningen.cljsbuild leiningen.garden]
  :ring {:handler webapp.core/app}
  :garden {:builds [{;; Optional name of the build:
                     :id "screen"
                     ;; Source paths where the stylesheet source code is
                     :source-paths ["src/clj/"]
                     ;; The var containing your stylesheet:
                     :stylesheet webapp.styles/screen
                     ;; Compiler flags passed to `garden.core/css`:
                     :compiler {;; Where to save the file:
                                :output-to "resources/public/css/styles.css"
                                ;; Compress the output?
                                :pretty-print? false}}]}
  :main webapp.core)
