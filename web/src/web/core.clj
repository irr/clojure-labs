(ns web.core #_{:clj-kondo/ignore [:use]}
             (:use clojure.data.json) (:gen-class))
(defn -main [& args]
  (println (json-str (list 1 2 3)) args))

(-main)


