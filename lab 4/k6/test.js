import http from 'k6/http'
import { check, sleep } from 'k6'


function randomIntBetween(min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min);
}

export const options = {
	scenarios: {
		products: {
			executor: 'ramping-vus',
			stages: [
				{ duration: '60s', target: 20 },
				{ duration: '60s', target: 20 },
				{ duration: '60s', target: 0 },
			]
		}
	}
}

export default function() {
	const productId = randomIntBetween(1, 1000)
	const timeout = randomIntBetween(1, 150)
	const url = `http://springboot-app:8080/products/${productId}?timeout={timeout}`
	const response = http.get(url)
	
	check(res, {
		'status': (r) => r.status === 200
	})
	
	sleep(0.25);
}