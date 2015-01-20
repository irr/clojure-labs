(defproject webkitredis "0.1.0-SNAPSHOT"
    :license {:name "Eclipse Public License"
              :url "http://www.eclipse.org/legal/epl-v10.html"}
    :dependencies [[org.clojure/clojure "1.6.0"] 
                   [http-kit "2.1.18"]
                   [org.clojure/data.json "0.2.5"]
                   [org.clojars.tnoda/simple-crypto "0.1.0"]
                   [com.taoensso/carmine "2.7.1"]]
    :profiles {:uberjar {:aot :all}}
    :main webkitredis.core)
