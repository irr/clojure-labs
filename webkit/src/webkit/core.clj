(ns webkit.core 
  (:use [org.httpkit.server] [clojure.data.json :only [json-str]])
  (:gen-class))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (json-str {"text" "hello HTTP!"})})

(defn -main [& args]
  (run-server app {:port 8080}))
