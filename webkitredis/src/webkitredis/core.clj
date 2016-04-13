(ns webkitredis.core 
    (:require [taoensso.carmine :as car]
              [org.clojars.tnoda.simple-crypto :as c])
    (:use [org.httpkit.server] 
          [clojure.data.json :only [json-str]])
    (:gen-class))

(def server-conn {:pool {} :spec {:host "127.0.0.1" :port 6379}})
(defmacro wcar* [& body] `(car/wcar server-conn ~@body))

(defn app [req]
    {:status  200
     :headers {"Content-Type" "application/json"}     
     ;;:body    (json-str {"crypt-bytearray" (c/encrypt (wcar* (car/ping)) "abcdefghijklmnop")})})
     :body    (json-str {"ping" (wcar* (car/ping))})})

(defn -main [& args]
    (run-server app {:port 8080}))
