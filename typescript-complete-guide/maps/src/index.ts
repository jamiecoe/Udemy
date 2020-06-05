import { User } from './User'
import { CustomMap } from './CustomMap'
import { Company } from './Company'

const user = new User()
const company = new Company()
const mapContainerId = 'map'
const map = new CustomMap(mapContainerId)

map.addMarker(user)
map.addMarker(company)
