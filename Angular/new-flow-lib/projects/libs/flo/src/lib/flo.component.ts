import { Component } from '@angular/core';
import { dia } from 'jointjs';
import { Flo } from '../public-api';
import { Editor } from './component/top-service/editor';
import { Metamodel } from './component/top-service/metamodel';
import { PropertiesEditorService } from './component/top-service/properties-editor.service';
import { Renderer } from './component/top-service/renderer';

@Component({
  selector: 'lib-flo',
  template: `
    <p>
      flo works!
    </p>
  `,
  styles: [
  ]
})
export class FloComponent {


  metamodel: Flo.Metamodel;
  renderer: Flo.Renderer;
  editor: Flo.Editor;
  dsl: string;
  dslEditor = false;

  editorContext!: Flo.EditorContext;

  paletteSize = 170;

  constructor(private propertiesEditor: PropertiesEditorService) {
    this.metamodel = new Metamodel();
    this.renderer = new Renderer();
    this.editor = new Editor(propertiesEditor);
    this.dsl = '';
  }

  arrangeAll() {
    this.editorContext.performLayout().then(() => this.editorContext.fitToPage());
  }

  markersChanged(markers: Map<string | number, Array<Flo.Marker>>) {
    console.log('MARKERS: ' + JSON.stringify(markers));
  }

  openPropertiesDialog(cell: dia.Cell) {
    this.propertiesEditor.openPropertiesDialog(cell)
  }

  processKeyUp(evt: KeyboardEvent): void {
    this.dsl = (evt.target as HTMLTextAreaElement).value;
  }


}
