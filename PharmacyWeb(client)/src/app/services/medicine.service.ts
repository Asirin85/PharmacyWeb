import {Medicine} from '../models/medicine';
import {Injectable} from '@angular/core';
import {ConstLib} from '../const.lib';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class MedicineService {

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get(ConstLib.WEB_URL + '/med');
  }

  getID(id: number) {
    return this.http.get(ConstLib.WEB_URL + '/med/' + id);
  }

  save(medicine: Medicine) {
    return this.http.put(ConstLib.WEB_URL + '/med', medicine);
  }

  delete(id: number) {
    return this.http.delete(ConstLib.WEB_URL + '/med/' + id);
  }

  add(medicine: Medicine) {
    return this.http.post(ConstLib.WEB_URL + '/med', medicine);
  }
}
