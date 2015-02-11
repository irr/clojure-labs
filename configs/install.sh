#!/bin/bash
echo "updating libraries..."
mkdir -p /opt/java/github
cd /opt/java/github
git clone https://github.com/clojure/clojure.git
cd clojure
git checkout gh-pages
cd..
git clone git@github.com:irr/ClojureProgramming.git
cd ClojureProgramming
git remote add upstream https://github.com/clojurebook/ClojureProgramming.git
git fetch upstream && git merge upstream/master && git push
cd ..
git clone git@github.com:irr/programming-clojure.git
cd programming-clojure
git remote add upstream https://github.com/stuarthalloway/programming-clojure.git
git fetch upstream && git merge upstream/master && git push
cd ..
git clone git@github.com:irr/http-kit.git
cd http-kit
git remote add upstream https://github.com/http-kit/http-kit.git
git fetch upstream && git merge upstream/master && git push
cd ~/gitf
ln -s /opt/java/github/ClojureProgramming
ln -s /opt/java/github/programming-clojure
ln -s /opt/java/github/http-kit

