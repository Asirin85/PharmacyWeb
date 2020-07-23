import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ConstLib} from '../const.lib';
import {Pharmacyt} from '../models/pharmacyt';
import * as moment from 'moment';

@Injectable()
export class PharmacytService {

  constructor(private http: HttpClient) {
  }

  getTime(work: string) {
    var time = moment(work, 'HH:mm');
    var timeRet = {hour: time.hour(), minute: time.minute()};
    return timeRet;
  }

  getAll() {
    return this.http.get(ConstLib.WEB_URL + '/phar');
  }

  getID(id: number) {
    return this.http.get(ConstLib.WEB_URL + '/phar/' + id);
  }

  save(pharmacyt: Pharmacyt) {
    return this.http.put(ConstLib.WEB_URL + '/phar', pharmacyt);
  }

  delete(id: number) {
    return this.http.delete(ConstLib.WEB_URL + '/phar/' + id);
  }

  add(pharmacyt: Pharmacyt) {
    return this.http.post(ConstLib.WEB_URL + '/phar', pharmacyt);
  }
}
