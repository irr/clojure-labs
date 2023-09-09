(ns core
  (:require [cheshire.core :as json]
            [taoensso.carmine :as car]
            [taoensso.timbre :as timbre]
            [taoensso.timbre.appenders (carmine :as car-appender)]))

(timbre/merge-config! {:appenders {:carmine (car-appender/carmine-appender)}})

(def redis-conn
  {:pool {}
   :spec {:uri "redis://localhost:6379/"}})

(defmacro wcar* [& body] `(car/wcar redis-conn ~@body))

(defn set-value [key value]
  (wcar* (car/set key value)))

(defn get-value [key]
  (wcar* (car/get key)))

(defn -main
  [& args]
  (set-value "hello" "world")
  (println "Stored value in Redis:" (get-value "hello")))
