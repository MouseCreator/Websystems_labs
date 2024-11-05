import http from 'k6/http'
import { check, sleep } from 'k6'


function randomIntBetween(min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}

export const options = {
	scenarios: {
		products: {
			executor: 'constant-arrival-rate',
			duration: '1m',
			rate: 1,
			preAllocatedVUs: 5,
			timeUnit: '5s',
			maxVUs: 40
		}
	}
}

export default function() {
	const productId = randomIntBetween(1, 1000)
	const timeout = randomIntBetween(1, 150)
	const url = `http://host.docker.internal:8081/products/${productId}?timeout=${timeout}`
	const response = http.get(url)
	
	check(response, {
		'status': (r) => r.status === 200
	})
	
	sleep(0.25);
}