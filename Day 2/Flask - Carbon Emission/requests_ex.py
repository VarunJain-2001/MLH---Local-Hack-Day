import requests

r = requests.put('http://127.0.0.1:5000/boat_freight', data={'km': 5000,
                                                             'tonnes': 100000})
print(r.status_code)
print(r.json())
