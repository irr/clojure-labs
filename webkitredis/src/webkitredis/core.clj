(ns webkitredis.core
  (:require [taoensso.carmine :as car])
  (:use [org.httpkit.server]
        [clojure.data.json :only [json-str]])
  (:gen-class))

(def server-conn {:pool {} :spec {:uri "redis://localhost:6379/"}})

(defmacro wcar* [& body] `(car/wcar server-conn ~@body))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (json-str {"ping" (wcar* (car/ping))})})

(defonce server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    ;; graceful shutdown: wait 100ms for existing requests to be finished
    ;; :timeout is optional, when no timeout, stop immediately
    (@server :timeout 100)
    (reset! server nil)))

(defn -main [& args]
  ;; The #' is useful when you want to hot-reload code
  ;; You may want to take a look: https://github.com/clojure/tools.namespace
  ;; and https://http-kit.github.io/migration.html#reload
  (reset! server (run-server #'app {:port 8080})))
