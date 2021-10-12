from flask import Flask, request
from flask_restful import Resource, Api, reqparse

app = Flask(__name__)
api = Api(app)

# miles = 0
# tones = 0
# tone_miles = 100
# US_truck_carbon_factor = 161.8
# grams_of_CO2 = US_truck_carbon_factor * tone_miles
# metric_tons = 1000000 / grams_of_CO2

empty_dict = {}

# IDEA: Fedex google maps tracking of route for caluations
# IDEA: USA and UK option


class caluate_road_freight(Resource):
    def get(self):
        return {'Message': 'Sucesss', 'data': 'dummy_data' + ' C02'}

    def put(self):
        parser = reqparse.RequestParser()
        parser.add_argument('miles')
        parser.add_argument('tons')
        parser.add_argument('ton_miles', type=float)
        args = parser.parse_args()

        if args['miles'] or args['tons'] is None:
            ton_miles = args['ton_miles']

        if args['ton_miles'] is None:
            miles = float(args['miles'])
            tons = float(args['tons'])
            ton_miles = miles * tons
        # tone_miles = float(args['tone_miles'])

        grams_of_CO2 = 161.8 * ton_miles
        metric_tons = grams_of_CO2 / 1000000

        Emmisons = round(metric_tons, 2)

        calculations = {'Emmisons': str(Emmisons) + ' metric tons CO2'}

        return calculations, 201


class caluate_boat_freight(Resource):
    def get(self):
        return {'Message': 'Sucesss', 'data': 'dummy_data' + ' C02'}

    def put(self):
        # uses european caluations and metric
        parser = reqparse.RequestParser()
        parser.add_argument('miles', type=float)
        parser.add_argument('km', type=float)
        parser.add_argument('tonnes', type=float)
        parser.add_argument('km/tonnes', type=float)
        parser.add_argument('miles/tonnes', type=float)
        args = parser.parse_args()
        print(args['miles'])
        print(args['km'])
        print(args['tonnes'])
        print(args['km/tonnes'])
        print(args['miles/tonnes'])

        if args['miles'] is not None:
            args['km'] = args['miles'] / 0.621371
            args['km/tonnes'] = args['km'] * args['tonnes']

        if args['miles/tonnes'] is not None:
            args['km/tonnes'] = args['miles/tonnes'] * 1.459972

        if args['km/tonnes'] is None:
            args['km/tonnes'] = args['km'] * args['tonnes']

        g_CO2_tonne_km = args['km/tonnes'] * 8
        print("g_CO2_tonne_km", g_CO2_tonne_km)
        metric_tons = g_CO2_tonne_km / 1000000
        Emmisons = round(metric_tons, 2)

        calculations = {'Emmisons': str(Emmisons) + ' tonnes of CO2'}

        return calculations, 201


api.add_resource(caluate_road_freight, '/road_freight')
api.add_resource(caluate_boat_freight, '/boat_freight')

if __name__ == '__main__':
    app.run(debug=True)
