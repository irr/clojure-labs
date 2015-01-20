(ns webkitsocket.core 
    (:use [org.httpkit.server])
    (:gen-class))

(defn async-handler [ring-request]
  (with-channel ring-request channel
    (if (websocket? channel)       
      (on-receive channel (fn [data]
                            (send! channel data)))
      (send! channel {:status 200
                      :headers {"Content-Type" "text/plain"}
                      :body    "Long polling?"}))))

;http://www.websocket.org/echo.html
(defn -main [& args]
    (run-server async-handler {:port 8080}))
