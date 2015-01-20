(ns webkitcli.core 
    (:require [org.httpkit.client :as http])
    (:gen-class))

(defn content ([r]
    (println "crawl: " @r)))

(defn crawl ([u] 
    (let [r (http/get u)]
        (content r))))

(defn async-content ([{:keys [status headers body error]}] 
    (if error
        (println "Failed, exception is " error)
        (println "Async HTTP GET: " headers))))

(defn async-crawl ([u] 
    (http/get u {:timeout 1000 :keepalive -1} async-content)))

(defn future-crawl ([urls]
    (let [futures (doall (map http/get urls))]
        (doseq [r futures]
            (println "future: " (apply dissoc @r [:body]))))))

(defn -main [& args]
    (async-crawl "http://clojure.org/")
    (future-crawl ["http://www.uol.com.br/" "http://www.google.com/"])
    (crawl "http://clojure.org/")
    (println "ok."))
