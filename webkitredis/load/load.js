// k6 run ./scripts/k6/load.js

import http from "k6/http";

export let options = {
    rps: 100, // maximum number of requests to make per second, in total across all VUs
    batch: 100, // maximum parallel batch requests that k6 will make per second
    //iterations: 10,
    vus: 100,
    duration: "5s",
    insecureSkipTLSVerify: false,
    noConnectionReuse: true,
    userAgent: "Go-irrlab-K6/1.0"
  };

export default function() {
    var params =  { 
        headers: { 
            "Accept-Language": "en",
            "Referer": "k6-irrlab-test",
            "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YzNmYjk1ZC1hNzQ1LTRlYWMtOTBiNS0xM2NmMGUwYjI1ZGQifQ.eyJqdGkiOiI2MjliZWY1ZC00YmU2LTRjYTQtOTJkZi00ZjVmMTE0MDM0MjEiLCJleHAiOjE2NTQxNTI4NTUsIm5iZiI6MCwiaWF0IjoxNjUxNTYwODU1LCJpc3MiOiJodHRwczovL2lkZW50aXR5Lmd5bXBhc3MuY29tL2F1dGgvcmVhbG1zL21hc3RlciIsInN1YiI6ImY6MTg1NjM2YjctNTUwNi00NjQ5LThmZTMtYzFjODVjYjgzMjE5OmM3NDlhYmYzLTgyYWItNDg2OC1hZDAzLTQ2N2ExMzc0MjFhNiIsInR5cCI6IkJlYXJlciIsImF6cCI6Im1vYmlsZS1zc28iLCJhdXRoX3RpbWUiOjAsInNlc3Npb25fc3RhdGUiOiI1NTdhNzg0NS03MjA3LTQ3OGUtOTdhNi02YWYwMzY3OWE4N2EiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInNjb3BlIjoiZ3ltcGFzcy1tb2JpbGUgdGFndXMgZW1haWwgbW9iaWxlX3JvbGVzIGd5bXBhc3MtY29yZSIsInVuaXF1ZV90b2tlbiI6IjMxMDY3MzY0MDAzMjYiLCJmaWQiOiJ0YWd1cyIsInVpZCI6ImM3NDlhYmYzLTgyYWItNDg2OC1hZDAzLTQ2N2ExMzc0MjFhNiIsImNvdW50cnlfY29kZSI6IlBUIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsInVzZXJfc2x1ZyI6Iml2YW4tcmliZWlyby1yb2NoYSIsImNvbXBhbnlfaWQiOm51bGwsInJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXSwibmFtZSI6Ikl2YW4gUmliZWlybyBSb2NoYSIsImxvY2FsZSI6InB0LVBUIiwiZW1haWwiOiJpdmFuLnJvY2hhK25ld0BneW1wYXNzLmNvbSIsInByb3ZpZGVycyI6bnVsbH0.Y8IQjA4fkzmYf-E51gHApyeDjYRdLyPwe3sl6BfzJI0"
        } 
    };
    let host = "http://localhost:8080/";
    let response = http.get(`${host}`, params);
}
