import { ElementRef, OnInit, AfterViewInit, AfterViewChecked, DoCheck, OnDestroy, IterableDiffers, TemplateRef, Renderer } from '@angular/core';
import { DomHandler } from '../dom/domhandler';
export declare class Carousel implements OnInit, AfterViewChecked, AfterViewInit, DoCheck, OnDestroy {
    private el;
    private domHandler;
    private renderer;
    value: any[];
    numVisible: number;
    firstVisible: number;
    headerText: string;
    circular: boolean;
    breakpoint: number;
    responsive: boolean;
    autoplayInterval: number;
    effectDuration: any;
    easing: string;
    pageLinks: number;
    style: any;
    styleClass: string;
    itemTemplate: TemplateRef<any>;
    private container;
    private left;
    private viewport;
    private itemsContainer;
    private items;
    private columns;
    private page;
    private valuesChanged;
    private interval;
    private anchorPageLinks;
    private mobileDropdownOptions;
    private selectDropdownOptions;
    private shrinked;
    documentResponsiveListener: any;
    differ: any;
    constructor(el: ElementRef, domHandler: DomHandler, differs: IterableDiffers, renderer: Renderer);
    ngDoCheck(): void;
    ngAfterViewChecked(): void;
    ngOnInit(): void;
    ngAfterViewInit(): void;
    updateLinks(): void;
    updateDropdown(): void;
    updateMobileDropdown(): void;
    render(): void;
    calculateItemWidths(): void;
    onNextNav(): void;
    onPrevNav(): void;
    setPage(p: any, enforce?: boolean): void;
    onDropdownChange(val: string): void;
    displayPageLinks: boolean;
    displayPageDropdown: boolean;
    totalPages: number;
    routerDisplay(): boolean;
    updateState(): void;
    startAutoplay(): void;
    stopAutoplay(): void;
    ngOnDestroy(): void;
}