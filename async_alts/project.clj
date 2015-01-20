(defproject async_alts "0.1.0-SNAPSHOT"
    :license {:name "Eclipse Public License"
              :url "http://www.eclipse.org/legal/epl-v10.html"}
    :dependencies [[org.clojure/clojure "1.5.1"] 
                   [org.clojure/core.async "0.1.0-SNAPSHOT"]]
    :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
    :profiles {:uberjar {:aot [async_alts.core]}}
    :main async_alts.core)
