(defproject web "1.0.0-SNAPSHOT"
  :description "basic web project"
  :dependencies [[org.clojure/clojure "1.11.1"] [org.clojure/data.json "2.4.0"]]
  :profiles {:uberjar {:aot :all}}
  :main web.core)
