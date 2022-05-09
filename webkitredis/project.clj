(defproject webkitredis "0.1.0-SNAPSHOT"
    :license {:name "Eclipse Public License"
              :url "http://www.eclipse.org/legal/epl-v10.html"}
    :dependencies [[org.clojure/clojure "1.11.1"] 
                   [http-kit "2.5.3"]
                   [org.clojure/data.json "0.2.6"]
                   [org.clojars.tnoda/simple-crypto "0.1.0"]
                   [com.taoensso/carmine "3.1.0"]]
    :profiles {:uberjar {:aot :all}}
    :main webkitredis.core)
