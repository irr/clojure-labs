
function j2x {
    cat ~/clojure/stub/stub.sh $1 > ${1%.jar}.run && chmod +x ${1%.jar}.run
}

alias clj='rlwrap -H /dev/null java -cp /opt/java/clojure-1.8.0/clojure-1.8.0.jar clojure.main'
