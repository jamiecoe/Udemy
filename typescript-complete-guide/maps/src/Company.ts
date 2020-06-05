import faker from 'faker'
import { Mappable } from './types'

export class Company implements Mappable {
  companyName: string
  catchPhrase: string
  location: {
    lat: number
    lng: number
  }

  constructor() {
    this.companyName = faker.company.companyName()
    this.catchPhrase = faker.company.catchPhrase()
    this.location = {
      lat: parseFloat(faker.address.latitude()),
      lng: parseFloat(faker.address.longitude())
    }
  }

  getMarkerContent(): string {
    return `
      <h1>company ${this.companyName}</h1>
      ${this.catchPhrase}
    `
  }
}
