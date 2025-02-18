<template>

    <div>
        <div class="detail-title">
        UserCredential
        </div>
        <v-col>
            <String label="Username" v-model="value.username" :editMode="editMode"/>
            <String label="Password" v-model="value.password" :editMode="editMode"/>
        </v-col>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </div>
</template>

<script>
import BaseEntity from './base-ui/BaseEntity.vue'
import BasePicker from './base-ui/BasePicker.vue'

export default {
    name: 'UserCredential',
    mixins:[BaseEntity],
    components:{
        BasePicker
    },
    data: () => ({
        path: 'UserCredentials',
    }),
    props: {
    },
    watch: {
        value(val){
            this.value = val;
            this.change();
        },
    },
    async created(){
        this.value = this.modelValue
        if (this.value && this.value.id !== undefined) {
            this.value = await this.repository.findById(this.value.id)
        }
    },
    methods: {
        pick(val){
            this.value = val;
            this.change();
        },
    }
}
</script>

