(defproject web "1.0.0-SNAPSHOT"
  :description "basic web project"
  :dependencies [[org.clojure/clojure "1.8.0"] [org.clojure/data.json "0.1.1"]]
  :profiles {:uberjar {:aot :all}}
  :main web.core)
