import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ConstLib} from '../const.lib';
import {Availability} from '../models/availability';

@Injectable()
export class AvailabilityService {

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get(ConstLib.WEB_URL + '/avail');
  }

  getID(id: number) {
    return this.http.get(ConstLib.WEB_URL + '/avail/' + id);
  }

  save(availability: Availability) {
    return this.http.put(ConstLib.WEB_URL + '/avail', availability);
  }

  delete(id: number) {
    return this.http.delete(ConstLib.WEB_URL + '/avail/' + id);
  }

  add(availability: Availability) {
    return this.http.post(ConstLib.WEB_URL + '/avail', availability);
  }
}
