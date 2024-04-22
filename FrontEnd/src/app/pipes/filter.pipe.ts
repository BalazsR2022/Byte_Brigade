import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter',
  standalone:false
})
export class FilterPipe implements PipeTransform {

  transform(jsonData: any[], filter: string): any[] {
    if (!filter) return jsonData;
    return jsonData.filter(item => {
      return item.title.toLowerCase().includes(filter.toLowerCase()) ||
             item.author.toLowerCase().includes(filter.toLowerCase()) ||
             item.category.toLowerCase().includes(filter.toLowerCase()) ||
             item.county.toLowerCase().includes(filter.toLowerCase()) ||
             item.quality.toLowerCase().includes(filter.toLowerCase());
    });
  }

}
