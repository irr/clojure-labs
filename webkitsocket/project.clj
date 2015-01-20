(defproject webkitsocket "0.1.0-SNAPSHOT"
    :license {:name "Eclipse Public License"
              :url "http://www.eclipse.org/legal/epl-v10.html"}
    :dependencies [[org.clojure/clojure "1.6.0"] 
                   [http-kit "2.1.18"]]
    :profiles {:uberjar {:aot :all}}
    :main webkitsocket.core)
