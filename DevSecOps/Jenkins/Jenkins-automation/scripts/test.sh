#bin/bash

my=$(env  | grep USER | grep -oe '[^=]*$');
echo "$my"
TEST_VAR='Hello World!'
echo "$my" >>op.txt
