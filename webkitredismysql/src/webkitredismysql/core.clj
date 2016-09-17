(ns webkitredismysql.core
    (:require [taoensso.carmine :as car]
              [org.clojars.tnoda.simple-crypto :as c]
              [clojure.java.jdbc :as sql])
    (:use [org.httpkit.server]
          [clojure.data.json :only [json-str]])
    (:gen-class))

(def server-conn {:pool {} :spec {:host "127.0.0.1" :port 6379}})
(defmacro wcar* [& body] `(car/wcar server-conn ~@body))

(def mysql-db {
      :subprotocol "mysql"
      :subname "//127.0.0.1:3306/mysql"
      :user "root"
      :password "mysql"})

(defn app [req]
    {:status  200
     :headers {"Content-Type" "application/json"}
     :body    (json-str {"ping" (wcar* (car/ping))
                         "root" (apply str (sql/query mysql-db ["select authentication_string from user where user='root'"]
                                                         {:row-fn :authentication_string}))})})

(defn -main [& args]
    (run-server app {:port 8080}))
