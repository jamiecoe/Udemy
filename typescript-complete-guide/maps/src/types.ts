interface Location {
  lat: number
  lng: number
}

export interface Mappable {
  location: Location
  getMarkerContent(): string
}
