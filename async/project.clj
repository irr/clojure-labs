(defproject async "0.1.0-SNAPSHOT"
  :description "clojure async as go"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"] [org.clojure/core.async "0.2.385"]]
  :main ^:skip-aot async.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
