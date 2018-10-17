#!/bin/bash

pushd `dirname $0`

rm -f AppSpec.zip
rm -rf AppSpec/contents
mkdir AppSpec/contents

cp ../target/rpm/RPMS/noarch/*.rpm AppSpec/contents/studyplaycodedeploy.rpm

pushd AppSpec
zip ../AppSpec.zip -r . -x .DS_Store
popd

rm -rf AppSpec/contents
popd
